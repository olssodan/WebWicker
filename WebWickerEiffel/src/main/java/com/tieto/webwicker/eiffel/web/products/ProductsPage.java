package com.tieto.webwicker.eiffel.web.products;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.fortsoft.pf4j.Extension;

import com.tieto.webwicker.api.web.BasePage;
import com.tieto.webwicker.api.web.TopLevelPage;
import com.tieto.webwicker.eiffel.model.Product;
import com.tieto.webwicker.eiffel.provider.ProductProvider;

@Extension
public class ProductsPage extends BasePage implements TopLevelPage {
	private static final long serialVersionUID = -2628622574983831269L;

	public static final int ORDER = 300;

	public ProductsPage(final PageParameters parameters) {
		super(parameters);

		final ProductProvider productProvider = new ProductProvider();
        
        List<IColumn<Product,String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<Product, String>(new Model<String>("ArtifactId"), "artifactId", "artifactId"));
        columns.add(new PropertyColumn<Product, String>(new Model<String>("Latest release"), "latestRelease", "latestRelease"));
        columns.add(new PropertyColumn<Product, String>(new Model<String>("Latest snapshot"), "latestSnapshot", "latestSnapshot"));
        columns.add(new PropertyColumn<Product, String>(new Model<String>("Commits in review"), "commitsInReview", "commitsInReview"));
         
        DefaultDataTable<Product,String> table = new DefaultDataTable<Product,String>("datatable", columns, productProvider, 20);
         
        add(table);
    }
}
