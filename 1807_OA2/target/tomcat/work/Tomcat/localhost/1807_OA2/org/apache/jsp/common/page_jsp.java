/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-12-07 10:58:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(request.getContextPath() + "/");
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"lib/layer/ui/css/layui.css\" media=\"all\">\r\n");
      out.write("\t<script src=\"lib/layer/ui/layui.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"lib/jquery/1.9.1/jquery.min.js\"></script>  \r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"test1\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t// 获取bodyId\r\n");
      out.write("\t\tvar bodyId = $(\"body\").attr(\"id\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t// 初始化分页导航条\r\n");
      out.write("\t\tlayui.use('laypage', function() {\r\n");
      out.write("\t\t\tvar laypage = layui.laypage;\r\n");
      out.write("\r\n");
      out.write("\t\t\t//执行一个laypage实例\r\n");
      out.write("\t\t\tlaypage.render({\r\n");
      out.write("\t\t\t\telem : 'test1', //注意，这里的 test1 是 ID，不用加 # 号\r\n");
      out.write("\t\t\t\tcount : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\", // 总条数\r\n");
      out.write("\t\t\t\tlimit:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.pageSize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\", // 每页显示的条数\r\n");
      out.write("\t\t\t\tcurr:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page.pageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\", // 当前页\r\n");
      out.write("\t\t\t\tlayout: ['prev', 'page', 'next', 'limit','count'],\r\n");
      out.write("\t\t\t\tjump: function(obj, first){\r\n");
      out.write("\t\t\t\t    //首次不执行\r\n");
      out.write("\t\t\t\t    if(!first){\r\n");
      out.write("\t\t\t\t    \t// 查询下一页的数据\r\n");
      out.write("// \t\t\t\t    \tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("currentPage=\"+obj.curr;\r\n");
      out.write("\t\t\t\t\t\t//load就是加载一个远程资源放到    \"#\"+bodyId ,load加载会覆盖原来数据\r\n");
      out.write("\t\t\t\t\t\t//参数1:页码\r\n");
      out.write("\t\t\t\t\t\t//参数2:getQueryParam()根据查询参数值:点击第二页时才会继续查第二内容\r\n");
      out.write("\t\t\t\t\t\t$(\"#\"+bodyId).load(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("currentPage=\"+obj.curr,getQueryParam());\r\n");
      out.write("\t\t\t\t    }\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 获取模块的查询参数\r\n");
      out.write("\t\tfunction getQueryParam(){\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
