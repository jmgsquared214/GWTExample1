package com.jyothi.web;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord; 

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
	  listGrid.setCanRemoveRecords(false);  
	  listGrid.setDataFetchMode(FetchMode.LOCAL);  
	  listGrid.setCanEdit(true);
	  listGrid.setAutoSaveEdits(false);
	  listGrid.setSaveByCell(false);
	 
	  DataSource dataSource = DataSource.get("contacts");
	  listGrid.setDataSource(dataSource);
	  listGrid.setAutoFetchData(true);
	    Canvas canvas = new Canvas();
	    IButton newButton = new IButton("Add New");  
	    newButton.setTop(250);
	    
	    IButton saveButton = new IButton("Save");
	    saveButton.setTop(250);
	    saveButton.setLeft(110);
        newButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
                listGrid.startEditingNew();  
            }  
        });  
        
        saveButton.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	GWT.log("Enteredsssds");listGrid.saveAllEdits();
	        	  for(ListGridRecord records: listGrid.getRecords())
	       	   {
	        		  GWT.log("Enteredsssds");
	        		 String id= records.getAttributeAsString("id");
	        		 if(null==id){
	        			 dataSource.addData(records);
	        		 }
	       	   }
	        }
	    });
        IButton deleteButton = new IButton("Delete");
        deleteButton.setTop(250);
        deleteButton.setLeft(250);
        deleteButton.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	  for(ListGridRecord records: listGrid.getSelectedRecords())
		       	   {
	        		  boolean checked = records.getAttributeAsBoolean("Delete");
	        		  consoleLog(" Delete"+checked);
	        			  dataSource.removeData(records);
		       	   }
	        }
	    });
        
	    canvas.addChild(listGrid);
	    canvas.addChild(newButton);
	    canvas.addChild(saveButton);
	    canvas.addChild(deleteButton);
		 
	   
	    RootPanel.get().add(canvas);
  }
 
 public void onFailure(Throwable caught) {
     // Show the RPC error message to the user
    GWT.log("error",caught);
   }
 
 native void consoleLog( String message) /*-{
 console.log( "me:" + message );
}-*/;
  
}