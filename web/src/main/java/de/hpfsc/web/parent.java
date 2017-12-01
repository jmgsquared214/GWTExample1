package de.hpfsc.web;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.FetchMode;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.RowEndEditAction;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class parent implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  
  private final AcademicWikiServiceAsync AcademicWikiService = GWT.create(AcademicWikiService.class);
	

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  RootPanel.get().add(getViewPanel());
	  
  }
 public Canvas  getViewPanel()
  {

	  Canvas canvas = new Canvas();
	  	      final ListGrid listGrid = new ListGrid();  
	  	      listGrid.setWidth(900);  
	  	      listGrid.setHeight(1000);  
	  	      listGrid.setAlternateRecordStyles(true);  
	  	      listGrid.setCanEdit(true);  
	  	      listGrid.setCanRemoveRecords(true);  
	  	      listGrid.setDataFetchMode(FetchMode.LOCAL);  
	  	      listGrid.setAutoFetchData(true);  
	  	      listGrid.setUseAllDataSourceFields(true);  
	  	      listGrid.setShowFilterEditor(true);  
	  	  // listGrid.setDataSource(DBDataSource.getInstance());
	  	      ListGridField resourceField = new ListGridField("resource", "Resource", 40);
	  	    resourceField.setCanEdit(true);
	  	      ListGridField linkField = new ListGridField("link", "Link");
	  	    resourceField.setCanEdit(true);
	  	      ListGridField pdfnameField = new ListGridField("pdfname", "PdfName", 225);
	  	      pdfnameField.setType(ListGridFieldType.DATE);
	  	    pdfnameField.setCanEdit(true);
	  	      ListGridField articlenameField = new ListGridField("articlename", "ArticleName");
	  	      articlenameField.setType(ListGridFieldType.INTEGER);
	  	    articlenameField.setCanEdit(true);
	  	      ListGridField studentnameField = new ListGridField("studentname", "StudentName");
	  	      studentnameField.setType(ListGridFieldType.FLOAT);
	  	    articlenameField.setCanEdit(true);

	  	      listGrid.setFields(new ListGridField[] {resourceField, linkField, pdfnameField,
	  	    		  articlenameField, studentnameField});
	  	      listGrid.setCanResizeFields(true);
	  	    listGrid.setCanEdit(true);
	  	    
	  		
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
					modelArray[i]=model1;
					i++;
				     
					}
				     
					 listGrid.setData(modelArray);
				}
			};
			
			greetingService.findAllEntries(modelObject);
			listGrid.setEditEvent(ListGridEditEvent.CLICK);
		  	  listGrid.setListEndEditAction(RowEndEditAction.NEXT);
		  	listGrid.setShowFilterEditor(true);
		canvas.addChild(listGrid);
			 IButton button = new IButton("Add New");
			 button.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					listGrid.startEditingNew();
					
				}
			});
			   canvas.addChild(button);

	  	  return canvas;
 
  }
  
}