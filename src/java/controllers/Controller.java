package controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public interface Controller
{
    public void execute();
    public void init(HttpServletRequest request);
    public String getReturnPage();
}
