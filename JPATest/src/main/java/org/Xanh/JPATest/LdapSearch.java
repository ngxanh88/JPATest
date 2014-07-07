package org.Xanh.JPATest;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LdapSearch {

	public static void main(String[] args) throws Exception {
	    Hashtable env = new Hashtable();

	    String sp = "com.sun.jndi.ldap.LdapCtxFactory";
	    env.put(Context.INITIAL_CONTEXT_FACTORY, sp);

	    String ldapUrl = "ldap://localhost:10389";
	    env.put(Context.PROVIDER_URL, ldapUrl);

	    DirContext dctx = new InitialDirContext(env);

	    String base = "ou=People,dc=example,dc=com";

	    SearchControls sc = new SearchControls();
	    String[] attributeFilter = { "cn", "mail" };
	    sc.setReturningAttributes(attributeFilter);
	    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

	    String filter = "(&(surname=Xuan)(mail=*))";

	    NamingEnumeration results = dctx.search(base, filter, sc);
	    while (results.hasMore()) {
	      SearchResult sr = (SearchResult) results.next();
	      Attributes attrs = sr.getAttributes();

	      Attribute attr = attrs.get("cn");
	      System.out.print(attr.get() + ": ");
	      attr = attrs.get("mail");
	      System.out.println(attr.get());
	    }
	    dctx.close();
	  }
}
