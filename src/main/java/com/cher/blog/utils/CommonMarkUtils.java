package com.cher.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CommonMarkUtils {

    private static int count = 1;

    private static List<Extension> extensions = Arrays.asList(TablesExtension.create());

    public static String parseToHtml(String markdown) {
        count = 1;
        Parser parser = Parser.builder().extensions(extensions).build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new HeadingAttributeProvider();
                    }
                })
                .extensions(extensions)
                .build();
        return renderer.render(document);
    }

    static class HeadingAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String s, Map<String, String> map) {
            if (node instanceof Heading) {
                map.put("id", "heading" + count++);
            }
        }
    }

}
