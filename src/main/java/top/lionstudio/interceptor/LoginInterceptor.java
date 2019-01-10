package top.lionstudio.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class LoginInterceptor implements  HandlerInterceptor {
	
	@SuppressWarnings("unchecked")
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		HttpSession httpSession=request.getSession();

		if(httpSession.getAttribute("USER")==null)
		{
			System.out.println("to login");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			@SuppressWarnings("rawtypes")
			Map res=new HashMap<>();
			res.put("status", -1);
			res.put("data", "session失效");
			
			out.print(new Gson().toJson(res));
			out.flush();
			out.close();
			return false;
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }


}
