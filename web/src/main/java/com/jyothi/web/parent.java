package com.jyothi.web;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.jyothi.web.AcademicWikiModel;
import com.jyothi.web.AcademicWikiService;
import com.jyothi.web.AcademicWikiServiceAsync;
import com.jyothi.web.model.AcademicWiki;
import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class parent implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   * 
   * 
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";
 
  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final AcademicWikiServiceAsync academicWikiService = GWT.create(AcademicWikiService.class);
  
  
  Logger logger = Logger.getLogger("Test1.java");

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  getViewPanel(); 
  }
	 

 public void  getViewPanel()
  {
	 final ListGrid listGrid = new ListGrid();  
	  listGrid.setWidth(900);  
	  listGrid.setHeight(224);  
	  listGrid.setAlternateRecordStyles(true);  
	  listGrid.setCanEdit(false);  
	  listGrid.setCanRemoveRecords(true);  
	  listGrid.setDataFetchMode(FetchMode.LOCAL);  
	  listGrid.setAutoFetchData(false);  
	  listGrid.setUseAllDataSourceFields(true);  
	  listGrid.setShowFilterEditor(true);  
	  listGrid.setAutoFetchData(false);
	  listGrid.setCanEdit(true);
	  listGrid.setAutoSaveEdits(false);
	  listGrid.setSaveByCell(false);
	  
	  ListGridField resourceField = new ListGridField("resource", "Resource", 120);
	  ListGridField linkField = new ListGridField("link", "Link");
	  ListGridField pdfnameField = new ListGridField("pdfname", "PdfName", 120);
	  ListGridField articlenameField = new ListGridField("articlename", "ArticleName");
	  ListGridField studentnameField = new ListGridField("studentname", "StudentName");
	  ListGridField checkBoxField = new ListGridField("delete");
	  checkBoxField.setType(ListGridFieldType.BOOLEAN);
	  checkBoxField.setCanToggle(true);
	  checkBoxField.setCanEdit(true);
	  listGrid.setFields(new ListGridField[] {resourceField, linkField, pdfnameField,
    		  articlenameField, studentnameField,checkBoxField});
	
	    Canvas canvas = new Canvas();
	    canvas.addChild(listGrid);
	    IButton button = new IButton("Add New");
	    button.setTop(250);
	    button.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	Record record = new Record();
	        	record.setAttribute("resource", "");
	        	record.setAttribute("link", "");
	        	record.setAttribute("pdfname", "");
	        	record.setAttribute("articlename", "");
	        	record.setAttribute("studentname", "");
	        	listGrid.startEditingNew(record);
	        }
	    });
	    IButton saveButton = new IButton("Delete");
	    saveButton.setTop(250);
	    saveButton.setLeft(250);
	    saveButton.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	listGrid.saveAllEdits();
	        	  for(ListGridRecord records: listGrid.getRecords())
		       	   {
	        		  boolean checked = records.getAttributeAsBoolean("delete");
	        		  consoleLog(" Delete"+checked);
	        		  if(checked)
	        		  {
	        			Long id=Long.parseLong(  records.getAttributeAsString("id"));
	        			consoleLog(" Deleteid"+id);
	        			GWT.log(id+"");
	        			academicWikiService.delete(id, new AsyncCallback<Void>() {
							
							@Override
							public void onSuccess(Void result) {
								// TODO Auto-generated method stub
								consoleLog(" DeleteidSuccess");
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								consoleLog(" DeleteidFail");
							}
						}) ;
	        		  }
		       	   }
	        	  
	        	  for(ListGridRecord records: listGrid.getRecords())
		       	   {
	        		  boolean checked = records.getAttributeAsBoolean("delete");
	        		  consoleLog(" Delete"+checked);
	        		  if(checked)
	        		  {
	        			  listGrid.removeData(records);
	        		  }
		       	   }
	        	
	        }
	    });
	    
	    IButton deleteButton = new IButton("Save");
	    deleteButton.setTop(250);
	    deleteButton.setLeft(110);
	    deleteButton.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	GWT.log("Enteredsssds");listGrid.saveAllEdits();
	        	  for(ListGridRecord records: listGrid.getRecords())
	       	   {
	        		  GWT.log("Enteredsssds");
	        		  AcademicWikiModel model = new AcademicWikiModel();
	        		 String id= records.getAttributeAsString("id");
	        		 if(null==id){
	       		  model.setResource(records.getAttributeAsString("resource"));
	       		model.setLink(records.getAttributeAsString("link"));
	       		model.setPdf(records.getAttributeAsString("pdfname"));
	       		
	       		model.setArticleName(records.getAttributeAsString("articlename"));
	       		model.setStudentName(records.getAttributeAsString("studentname"));
	       		academicWikiService.saveOrUpdate(model, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						  GWT.log("Success");
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						  GWT.log("failure");
						
					}
				});
	        		 }
	       	   }
	        	 
	        }
	    });
	    
	    listGrid.addRecordClickHandler(new RecordClickHandler() {
	        @Override
	        public void onRecordClick(RecordClickEvent event) {
	            // your code
	        	 GWT.log("Entered1");
	        }
	});
	    
	    AsyncCallback<List<AcademicWikiModel>> modelObject= new AsyncCallback<List<AcademicWikiModel>>() {

			@Override
			public void onFailure(Throwable caught) {
				AcademicWiki model = new AcademicWiki();
				model.setLink("failed");
				 AcademicWiki[] modelArray = new AcademicWiki[1];
				modelArray[0]=model;
			      listGrid.setData(modelArray);
			}

			@Override
			public void onSuccess(List<AcademicWikiModel> result) {
				AcademicWiki[] modelArray = new AcademicWiki[result.size()];
				int i=0;
				for(AcademicWikiModel model: result)
				{
				AcademicWiki model1 = new AcademicWiki();
				model1.setLink(model.getLink());
				model1.setResource(model.getResource());
				model1.setStudentName(model.getStudentName());
				model1.setArticleName(model.getArticleName());
				consoleLog(model.getPdf());
				model1.setPdf(model.getPdf());
				consoleLog("Id is"+model.getId());
				model1.setId(model.getId());
				model1.setDelete(false);
				modelArray[i]=model1;
				i++;
			     
				}
			     
				 listGrid.setData(modelArray);
			}
		};
		
		academicWikiService.findAllEntries(modelObject);
	    canvas.addChild(button);
	  
	    canvas.addChild(saveButton);
	    
	    canvas.addChild(deleteButton);
	   
	    RootPanel.get().add(canvas);
  }
 
 native void consoleLog( String message) /*-{
 console.log( "me:" + message );
}-*/;
  
}