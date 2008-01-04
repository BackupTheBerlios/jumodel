<ui:composition template="#{appCtx.mainRes}/layouts/mainLayout.xhtml"
	xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:c="http://java.sun.com/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions">
      	 
    <ui:define name="content">
    	${cursor}
    </ui:define>
</ui:composition>