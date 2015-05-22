package org.apache.jsp.WEB_002dINF.decorators;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class decorator1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/includes/header.jsp");
    _jspx_dependants.add("/WEB-INF/includes/menu.jsp");
    _jspx_dependants.add("/WEB-INF/includes/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005ftitle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fdecorator_005ftitle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fdecorator_005ftitle.release();
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.release();
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.release();
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<!--    http://www.luckyryan.com/2013/02/06/setup-a-simple-spring-mvc-site-with-maven/  -->\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/style.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/bootstrap.min.css\">\r\n");
      out.write("<title>");
      if (_jspx_meth_decorator_005ftitle_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      if (_jspx_meth_decorator_005fhead_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("<nav class=\"navbar navbar-inverse\" role=\"navigation\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"home\">School of Languages</a>\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"home\"><span class=\"glyphicon glyphicon-home\"\r\n");
      out.write("\t\t\t\t\t\t\taria-hidden=\"true\"></span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"formationlist\">Consulter les formations</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Contact us</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">About</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">Dropdown\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Action</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Another action</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Something else here</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">Separated link</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">One more separated link</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("<div id=\"notification-message\"> \r\n");
      out.write("    <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${messageSuccess}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</strong>\r\n");
      out.write("</div>\t\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t<h1><center> Hello World</center></h1>\r\n");
      out.write("\t\t    <center><a href=\"#\" id=\"lien\"><img src=\"resources/images/imageLangue1.gif\" alt=\"livre\"></a></center>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("  <!-- Indicators -->\r\n");
      out.write("  <ol class=\"carousel-indicators\">\r\n");
      out.write("    <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("    <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\r\n");
      out.write("    <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\r\n");
      out.write("    <li data-target=\"#carousel-example-generic\" data-slide-to=\"3\"></li>\r\n");
      out.write("  </ol>\r\n");
      out.write("\r\n");
      out.write("  <!-- Wrapper for slides -->\r\n");
      out.write("  <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("    <div class=\"item active\">\r\n");
      out.write("      <img src=\"resources/images/livre.gif\" alt=\"livre\">\r\n");
      out.write("      <div class=\"carousel-caption\">\r\n");
      out.write("        ...\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"item\">\r\n");
      out.write("      <img src=\"resources/images/imageLangue2.gif\" alt=\"langue\"> \r\n");
      out.write("      <div class=\"carousel-caption\">\r\n");
      out.write("        ...\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"item\">\r\n");
      out.write("      <img src=\"resources/images/salleLangue.jpg\" alt=\"sale\">\r\n");
      out.write("      <div class=\"carousel-caption\">\r\n");
      out.write("        ...\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ...\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- Controls -->\r\n");
      out.write("  <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("    <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("    <span class=\"sr-only\">Previous</span>\r\n");
      out.write("  </a>\r\n");
      out.write("  <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("    <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("    <span class=\"sr-only\">Next</span>\r\n");
      out.write("  </a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#notification-message\").show().delay(5000);\r\n");
      out.write("\t\t$(\"#notification-message\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("</script>\t");
      out.write("\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t");
      out.write("<html>\r\n");
      out.write("    <ul role=\"menu\">\r\n");
      out.write("     <li><a href=\"statutprofessionnelregister\">Ajout Statut\r\n");
      out.write("\t\t\t\t\t\t\t\tProfessionnel</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"formateurregister\">Ajout Formateur</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"formationregister\">Ajout Formation</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"localregister\">Ajout Local</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"participantregister\">Ajout Participant</a></li>\r\n");
      out.write("\t\t\t\t\t\t <li><a href=\"formationlistmenu\">Inscrire un nouveau participant au cours</a></li>\r\n");
      out.write("\t\t\t\t\t\t <li><a href=\"participantformationlistmenu\">Réinscrire un participant au cours</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"detailformationregister\">Associer local-formation</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"formateurlist\">Liste Formateur</a> </li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"anneescolaireregister\">Date Rentrée</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"reservationregister\">Soumettre une demande\r\n");
      out.write("\t\t\t\t\t\t\t\tpour inscription</a></li>  \t\r\n");
      out.write("\t</ul>\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"col-md-9 shool-decorator-body\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_decorator_005fbody_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<footer class=\"school-footer\">\r\n");
      out.write("\t");
      out.write("<div class=\"container\">\r\n");
      out.write("\t\t\t<span>This is my footer</span>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/bootstrap.min.js\"></script>\r\n");
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

  private boolean _jspx_meth_decorator_005ftitle_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  decorator:title
    com.opensymphony.module.sitemesh.taglib.decorator.TitleTag _jspx_th_decorator_005ftitle_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.TitleTag) _005fjspx_005ftagPool_005fdecorator_005ftitle.get(com.opensymphony.module.sitemesh.taglib.decorator.TitleTag.class);
    _jspx_th_decorator_005ftitle_005f0.setPageContext(_jspx_page_context);
    _jspx_th_decorator_005ftitle_005f0.setParent(null);
    int _jspx_eval_decorator_005ftitle_005f0 = _jspx_th_decorator_005ftitle_005f0.doStartTag();
    if (_jspx_eval_decorator_005ftitle_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_decorator_005ftitle_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_decorator_005ftitle_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_decorator_005ftitle_005f0.doInitBody();
      }
      do {
        out.write("School Of Language");
        int evalDoAfterBody = _jspx_th_decorator_005ftitle_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_decorator_005ftitle_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_decorator_005ftitle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdecorator_005ftitle.reuse(_jspx_th_decorator_005ftitle_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdecorator_005ftitle.reuse(_jspx_th_decorator_005ftitle_005f0);
    return false;
  }

  private boolean _jspx_meth_decorator_005fhead_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  decorator:head
    com.opensymphony.module.sitemesh.taglib.decorator.HeadTag _jspx_th_decorator_005fhead_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.HeadTag) _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.HeadTag.class);
    _jspx_th_decorator_005fhead_005f0.setPageContext(_jspx_page_context);
    _jspx_th_decorator_005fhead_005f0.setParent(null);
    int _jspx_eval_decorator_005fhead_005f0 = _jspx_th_decorator_005fhead_005f0.doStartTag();
    if (_jspx_th_decorator_005fhead_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.reuse(_jspx_th_decorator_005fhead_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdecorator_005fhead_005fnobody.reuse(_jspx_th_decorator_005fhead_005f0);
    return false;
  }

  private boolean _jspx_meth_decorator_005fbody_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  decorator:body
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_decorator_005fbody_005f0 = (com.opensymphony.module.sitemesh.taglib.decorator.BodyTag) _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.get(com.opensymphony.module.sitemesh.taglib.decorator.BodyTag.class);
    _jspx_th_decorator_005fbody_005f0.setPageContext(_jspx_page_context);
    _jspx_th_decorator_005fbody_005f0.setParent(null);
    int _jspx_eval_decorator_005fbody_005f0 = _jspx_th_decorator_005fbody_005f0.doStartTag();
    if (_jspx_th_decorator_005fbody_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.reuse(_jspx_th_decorator_005fbody_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdecorator_005fbody_005fnobody.reuse(_jspx_th_decorator_005fbody_005f0);
    return false;
  }
}
