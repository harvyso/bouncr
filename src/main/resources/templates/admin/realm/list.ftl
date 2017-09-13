<#import "../../layout/defaultLayout.ftl" as layout>
<@layout.layout "List of realms">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${urlFor('net.unit8.bouncr.web.controller.admin.IndexController', 'home')}">Administration</a></li>
    <li class="breadcrumb-item active">Realms</li>
  </ol>
  <h1>List of realms</h1>

  <#list realms>
  <table class="table">
    <thead>
      <tr>
        <th>${t('field.name')}</th>
        <th>${t('field.description')}</th>
      </tr>
    </thead>
    <tbody>
      <#items as realm>
        <tr>
          <td><a href="${urlFor('edit?applicationId=' + applicationId + '&id=' + realm.id)}">${realm.name}</a></td>
          <td>${realm.description}</td>
        </tr>
      </#items>
    </tbody>
  </table>
  <#else>
  <div class="alert alert-info" role="alert">
     <p>No realms</p>
  </div>
  </#list>

  <a href="${urlFor('newForm?applicationId=' + applicationId)}">New register</a>
  <a href="${urlFor('net.unit8.bouncr.web.controller.admin.ApplicationController', 'list?id=' + applicationId)}">Back to application</a>
</@layout.layout>