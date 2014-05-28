package resteasy;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Provider
@Consumes({ "application/*+json", "text/json" })
@Produces({ "application/*+json", "text/json" })
public class JacksonProvider extends JacksonJsonProvider {

	private final ArrayList<Object> headerAccessControl;

	public JacksonProvider() {
		super(getObjectMapper());

		this.headerAccessControl = new ArrayList<Object>();
		headerAccessControl.add("*");
	}

	private static ObjectMapper getObjectMapper() {
		ObjectMapper objmapper = new ObjectMapper();
		objmapper.configure(Feature.WRITE_NULL_MAP_VALUES, false);
		objmapper.setSerializationConfig(objmapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));

		return objmapper;
	}

}
