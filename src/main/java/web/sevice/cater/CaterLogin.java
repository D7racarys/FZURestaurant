package web.sevice.cater;

import MyBatis.mapper.ClientsMapper;
import MyBatis.pojo.Clients;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static web.utils.SqlSessionFactoryUtils.getSqlSessionFactory;

@WebServlet("/caterLogin")
public class CaterLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();

        String json = br.readLine();// 得到json

        System.out.println(json);

        System.out.println("开始");

        Map map = JSON.parseObject(json, Map.class);

        for (Object o : map.keySet()) {
            System.out.println(map.get(o));
        }

        String username = (String) map.get("username");

        String password = (String) map.get("password");

        response.setContentType("text/html;charset=utf-8");

        if((username.equals("cater1") && password.equals("1234")) ||
                (username.equals("cater2") && password.equals("5678"))){

            System.out.println("successfully login");

            response.getWriter().write("true");
        }
        else {
            System.out.println("cater login failed");

            response.getWriter().write("false");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
