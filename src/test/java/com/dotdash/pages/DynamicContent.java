package com.dotdash.pages;

import annotations.Url;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.pageobject.WebPage;

import java.util.List;
import java.util.stream.Collectors;

@Url("/dynamic_content")
public class DynamicContent extends WebPage {

    @FindBy(css = ".columns > img")
    private List<WebElement> dynamicImages;

    @FindBy(css = "#content >.row > .large-10")
    private List<WebElement> dynamicItemsDescription;

    public List<String> getItemsDescription() {
        return dynamicItemsDescription.stream().map(this::getText).collect(Collectors.toList());
    }

    public List<String> getImagesSrc() {
        return dynamicImages.stream().map(image -> image.getAttribute("src")).collect(Collectors.toList());
    }
}
