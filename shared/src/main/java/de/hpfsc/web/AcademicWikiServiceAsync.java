package de.hpfsc.web;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AcademicWikiServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see de.hpfsc.web.AcademicWikiService
     */
    void greetServer( java.lang.String name, AsyncCallback<java.lang.String> callback );
    void delete(java.lang.Long book, com.google.gwt.user.client.rpc.AsyncCallback<java.lang.Void> arg2);
	void find(long id, com.google.gwt.user.client.rpc.AsyncCallback<de.hpfsc.web.AcademicWikiModel> arg2);
	void findAllEntries(com.google.gwt.user.client.rpc.AsyncCallback<java.util.List<de.hpfsc.web.AcademicWikiModel>> arg1);
	void saveOrUpdate(de.hpfsc.web.AcademicWikiModel book, com.google.gwt.user.client.rpc.AsyncCallback<java.lang.Void> arg2);



    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static AcademicWikiServiceAsync instance;

        public static final AcademicWikiServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (AcademicWikiServiceAsync) GWT.create( AcademicWikiService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
