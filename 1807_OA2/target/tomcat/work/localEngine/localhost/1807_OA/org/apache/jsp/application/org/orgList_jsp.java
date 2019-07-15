package org.apache.jsp.application.org;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class orgList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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
      out.write("     \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<base href=\"");
      out.print(request.getContextPath()+"/");
      out.write("\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/H-ui.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/H-ui.admin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"lib/Hui-iconfont/1.0.1/iconfont.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<title>角色管理</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"breadcrumb\">\r\n");
      out.write("\t<i class=\"Hui-iconfont\">&#xe67f;</i> 首页 \r\n");
      out.write("\t<span class=\"c-gray en\">&gt;</span> \r\n");
      out.write("\t数据管理 <span class=\"c-gray en\">&gt;</span> \r\n");
      out.write("\t组织管理 \r\n");
      out.write("\t<a class=\"btn btn-success radius r mr-20\" style=\"line-height:1.6em;margin-top:3px\" href=\"javascript:location.replace(location.href);\" title=\"刷新\" >\r\n");
      out.write("\t\t<i class=\"Hui-iconfont\">&#xe68f;</i>\r\n");
      out.write("\t</a>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"\">\r\n");
      out.write("\t<div class=\"cl pd-5 bg-1 bk-gray\"> \r\n");
      out.write("\t\t<span class=\"l\"> \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<a href=\"javascript:;\" onclick=\"datadel()\" class=\"btn btn-danger radius\">\r\n");
      out.write("\t\t\t\t<i class=\"Hui-iconfont\">&#xe6e2;</i> 批量删除\r\n");
      out.write("\t\t\t</a> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<a class=\"btn btn-primary radius\" href=\"javascript:;\" onclick=\"org_add('添加组织','orgController/toAddOrg','700','500')\">\r\n");
      out.write("\t\t\t\t<i class=\"Hui-iconfont\">&#xe600;</i> 添加组织\r\n");
      out.write("\t\t\t</a> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</span>  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table class=\"table table-border table-bordered table-hover table-bg\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr class=\"text-c\">\r\n");
      out.write("\t\t\t\t<th width=\"25\"><input type=\"checkbox\" value=\"\" name=\"\"></th>\r\n");
      out.write("\t\t\t\t<th width=\"40\">ID</th>\r\n");
      out.write("\t\t\t\t<th width=\"200\">组织名称</th>\r\n");
      out.write("\t\t\t\t<th width=\"200\">父组织名称</th>\r\n");
      out.write("\t\t\t\t<th width=\"200\">组织描述</th>\r\n");
      out.write("\t\t\t\t<th width=\"60\">显示顺序</th>\r\n");
      out.write("\t\t\t\t<th width=\"70\">是否可用</th>\r\n");
      out.write("\t\t\t\t<th width=\"150\">创建时间</th>\r\n");
      out.write("\t\t\t\t<th width=\"70\">操作</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/page.jsp", out, false);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/jquery/1.9.1/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/layer/1.9.3/layer.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/My97DatePicker/WdatePicker.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/H-ui.admin.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*管理员-角色-添加*/\r\n");
      out.write("function org_add(title,url,w,h){\r\n");
      out.write("\tlayer_show(title,url,w,h);\r\n");
      out.write("}\r\n");
      out.write("/*管理员-角色-编辑*/\r\n");
      out.write("function admin_role_edit(title,url,id,w,h){\r\n");
      out.write("\tlayer_show(title,url,w,h);\r\n");
      out.write("}\r\n");
      out.write("/*管理员-角色-删除*/\r\n");
      out.write("function admin_role_del(obj,id){\r\n");
      out.write("\tlayer.confirm('角色删除须谨慎，确认要删除吗？',function(index){\r\n");
      out.write("\t\t//此处请求后台程序，下方是成功后的前台处理……\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(obj).parents(\"tr\").remove();\r\n");
      out.write("\t\tlayer.msg('已删除!',{icon:1,time:1000});\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /application/org/orgList.jsp(62,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/application/org/orgList.jsp(62,3) '${page.list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${page.list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /application/org/orgList.jsp(62,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("org");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<tr class=\"text-c\">\r\n");
          out.write("\t\t\t\t\t<td><input type=\"checkbox\" value=\"\" name=\"\"></td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.orgId }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.orgName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.orgParentName }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.orgDesc }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.dispIndex }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.state eq '1'? \"可用\":\"禁用\"}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td>");
          if (_jspx_meth_fm_005fformatDate_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t<td class=\"f-14\"><a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_role_edit('角色编辑','admin-role-add.html','1')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"admin_role_del(this,'1')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td>\r\n");
          out.write("\t\t\t\t</tr>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fm_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fm:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fm_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fm_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fm_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /application/org/orgList.jsp(71,9) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fm_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${org.createdDate}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /application/org/orgList.jsp(71,9) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fm_005fformatDate_005f0.setPattern("yyyy-MM-dd HH:mm:ss");
    int _jspx_eval_fm_005fformatDate_005f0 = _jspx_th_fm_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fm_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fm_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffm_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fm_005fformatDate_005f0);
    return false;
  }
}
