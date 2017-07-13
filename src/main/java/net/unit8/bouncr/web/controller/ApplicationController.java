package net.unit8.bouncr.web.controller;

import enkan.component.doma2.DomaProvider;
import enkan.data.HttpResponse;
import kotowari.component.TemplateEngine;
import net.unit8.bouncr.web.form.UserForm;

import javax.inject.Inject;

/**
 * @author kawasima
 */
public class ApplicationController {
    @Inject
    private TemplateEngine templateEngine;

    @Inject
    private DomaProvider daoProvider;

    public HttpResponse newForm() {
        UserForm application = new UserForm();
        return templateEngine.render("application/new",
                "application", application);
    }

}