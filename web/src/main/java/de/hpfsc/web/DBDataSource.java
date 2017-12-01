package de.hpfsc.web;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

public class DBDataSource extends DataSource {
	
	 private static DBDataSource instance = null;
	 public static DBDataSource getInstance() {
	      if (instance == null) {
	        instance = new DBDataSource();
	      }
	      return instance;
	    }

	 public DBDataSource() {
		 DataSourceField resourceField = new DataSourceField("resource",FieldType.TEXT, "Resource");
	  	    resourceField.setCanEdit(true);
	  	  DataSourceField linkField = new DataSourceField("link",FieldType.TEXT, "Link");
	  	    resourceField.setCanEdit(true);
	  	  DataSourceField pdfnameField = new DataSourceField("pdfname", FieldType.TEXT,"PdfName", 225);
	  	    pdfnameField.setCanEdit(true);
	  	  DataSourceField articlenameField = new DataSourceField("articlename",FieldType.TEXT, "ArticleName");
	  	    articlenameField.setCanEdit(true);
	  	  DataSourceField studentnameField = new DataSourceField("studentname",FieldType.TEXT, "StudentName");
	  	    articlenameField.setCanEdit(true);

	      setFields(resourceField, linkField, articlenameField, studentnameField, pdfnameField);
	      setDataURL("///");
	    }

}
