package tags;

import groovy.lang.Closure;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.MenuItem;

import play.templates.FastTags;
import play.templates.FastTags.Namespace;
import play.templates.GroovyTemplate.ExecutableTemplate;

@Namespace(value = "play.component")
public class MenuComponent extends FastTags {
	
	public final static String SHOW_ADMIN_ITEMS = "showAdminItems";
	public final static String TEMPLATE = "template";
	public final static String MENU_ITEMS = "menuItems";
	
	public static void _menu(Map<?, ?> args, Closure body, PrintWriter out, 
			   ExecutableTemplate template, int fromLine) {
		
		// récupération de paramètre passé par l'appelant
		Boolean showAdminItems = (Boolean) args.get(SHOW_ADMIN_ITEMS);
		
		//récupération des données
		List<MenuItem> menuItems = MenuItem.findMenuItems(showAdminItems);
		
		// on prépare la liste des paramètres dont le template aura besoin
		Map<String, Object> menuArgs = new HashMap<String, Object>();
		menuArgs.put("arg", (String) args.get(TEMPLATE));
		menuArgs.put(SHOW_ADMIN_ITEMS, showAdminItems);
		menuArgs.put(MENU_ITEMS, menuItems);
		
		// rendu du template
		_render(menuArgs, body, out, template, fromLine);
	}
}
