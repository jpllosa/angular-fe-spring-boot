package com.blogspot.jpllosa.transformer;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceTransformer;
import org.springframework.web.servlet.resource.ResourceTransformerChain;
import org.springframework.web.servlet.resource.TransformedResource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class IndexTransformer implements ResourceTransformer {
	@Override
	public Resource transform(HttpServletRequest request, Resource resource, ResourceTransformerChain chain) throws IOException {
		String html = IOUtils.toString(resource.getInputStream(), "UTF-8");
		html = html.replace("<!-- INJECT_HERE -->", 
			"<script src=\"//third.party.com/ab-testing.js\"> </script>");
		return new TransformedResource(resource, html.getBytes());
	}
}
