package com.weiyi.operation.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

@Service
public class SystemLogoutFilter extends LogoutFilter {
	
	@Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		String redirectUrl = getRedirectUrl(request, response, subject);
        try {
        	subject.logout();
        } catch (SessionException ise) {
           ise.printStackTrace();
        }
        
        //清空session
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        
        issueRedirect(request, response, redirectUrl);
        return false;
    }
}
