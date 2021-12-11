package com.rd.rivuletdigital.model

class ProjectListModel(var data:DataProjectList) {}
class DataProjectList(var data:List<DataProject>) {}
class DataProject(var project_id:String,var workspace_id:String ,var title:String,var project_status_text:String
,var status_text_color:String,var project_due_date:String,var project_client_name:String) {}