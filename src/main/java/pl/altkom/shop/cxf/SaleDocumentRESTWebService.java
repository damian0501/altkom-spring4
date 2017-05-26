package pl.altkom.shop.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import pl.altkom.shop.model.SaleDocument;

@Component
@Path("/saleDocument")
@Produces(MediaType.APPLICATION_JSON)
public class SaleDocumentRESTWebService {
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SaleDocument findById(@PathParam("id") Long id) {
		SaleDocument saleDocument = new SaleDocument();
		saleDocument.setNumber("REST " + id);
		return saleDocument;
	}

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public SaleDocument save(@RequestBody SaleDocument saleDocument) {
		saleDocument.setNumber("REST " + 1);
		return saleDocument;
	}
}
