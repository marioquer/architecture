package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import service.admincheck.AdminCheck;
import vo.ShoppingCart;
import vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/12.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminCheck adminCheck;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String email, String password, HttpServletRequest request) {
        UserVO userVO = userService.login(email, password);
        if (userVO == null) {
            return "fail";
        } else {
            ShoppingCart cart = new ShoppingCart();
            Double allcost = 0.0;
            request.getSession().setAttribute("user", userVO);
            request.getSession().setAttribute("shoppingCart", cart);
            request.getSession().setAttribute("allcost", allcost);
            if(userVO.getState()==1){
                return "user";  //普通用户
            }else if(userVO.getState()==-1){
                return "wateruser";  //水军
            }else if(userVO.getState()==0){
                return "un";  //用户审核中
            }else if(userVO.getState()==2){
                return "shop";  //商家
            }else if(userVO.getState()==3){
                return "manager";  //管理员
            }else{
                return "fail";  //非法用户
            }
        }
    }

    @RequestMapping(value = "/logup")
    @ResponseBody
    public String logup(String username, String password, String email, String address, HttpServletRequest request, Integer state) {
        UserVO userVO = new UserVO();
        userVO.setName(username);
        userVO.setPassword(password);
        userVO.setEmail(email);
        userVO.setAddress(address);
        userVO.setState(state);
        UserVO result  = userService.register(userVO);
        if (result == null) {
            return "fail";
        } else {
            return "success";
        }
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "success";
    }

    /**
     * 冻结水军
     * */
    @RequestMapping(value = "/freezeUser")
    @ResponseBody
    public String freezeUser(int userId) {

        adminCheck.freezeUser(userId, "never");
        return "success";
    }

}
