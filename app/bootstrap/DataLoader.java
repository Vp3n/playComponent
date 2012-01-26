package bootstrap;

import models.MenuItem;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class DataLoader extends Job {
	
	@Override
	public void doJob() throws Exception {
		if(Play.mode.isDev() && MenuItem.count() == 0) {
			Fixtures.loadModels("_010_menuItem.yml");
		}
	}

}
