package resteasy;

import it.carlom.amandolaelezioni.ApiManager;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestEasyApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RestEasyApplication() {

		singletons.add(new ApiManager());

	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
