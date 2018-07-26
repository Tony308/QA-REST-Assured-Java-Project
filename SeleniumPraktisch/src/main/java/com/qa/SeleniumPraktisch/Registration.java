package com.qa.SeleniumPraktisch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Registration {

	
    @FindBy(id = "name_3_firstname")
    private WebElement firstname;

    @FindBy(id = "name_3_lastname")
    private WebElement lastname;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[3]")
    private WebElement maritalStatus;

    @FindBy(name = "checkbox_5[]")
    private WebElement hobby;

    @FindBy(id = "dropdown_7")
    private WebElement country;

    @FindBy(className = "piereg_pass")
    private WebElement passwordStrength;
    
    @FindBy(id = "mm_date_8")
    private WebElement month;


    private Actions action;

    public void registerSomeone(WebDriver driver) throws InterruptedException {
    	
        action = new Actions(driver);
        
        FileInputStream file = null;

        try {
            file = new FileInputStream(Constant.filepath + Constant.file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            System.out.println(e);
        }

        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFCell cell = sheet.getRow(1).getCell(0);

        inputFirstname(cell.getStringCellValue());
//
        //enter lastname
        cell = sheet.getRow(1).getCell(1);
        action.sendKeys(Keys.TAB, cell.getStringCellValue()).perform();
        
        maritalStatus.click();
        hobby.click();

//      selects country
        cell = sheet.getRow(1).getCell(2);
        inputCountry(cell.getStringCellValue());
        action.sendKeys(Keys.RETURN).perform();
        
        
        //Enter month
        cell = sheet.getRow(1).getCell(3);
        action.sendKeys(cell.getRawValue().toString(), Keys.TAB).perform();
        
  
        //enter day
        cell = sheet.getRow(1).getCell(4);
        action.sendKeys(Keys.TAB, cell.getRawValue().toString()).perform();

//        enter year
        cell = sheet.getRow(1).getCell(5);
        action.sendKeys(Keys.TAB, cell.getRawValue()).perform();

        //mobile
        cell = sheet.getRow(1).getCell(6);
        action.sendKeys(Keys.TAB, cell.getRawValue().toString()).perform();

        //username
        cell = sheet.getRow(1).getCell(7);
        action.sendKeys(Keys.TAB, cell.getStringCellValue()).perform();

        //email
        cell = sheet.getRow(1).getCell(8);
        action.sendKeys(Keys.TAB, cell.getStringCellValue(), Keys.TAB, Keys.TAB).perform();
        
        cell = sheet.getRow(1).getCell(9);
        action.sendKeys(cell.getStringCellValue().toString(), Keys.TAB).perform();
        
        cell = sheet.getRow(1).getCell(10);
        action.sendKeys(cell.getStringCellValue().toString(), Keys.TAB).perform();
        
        
    }

    public void inputFirstname(String firstname) {
        this.firstname.click();
        this.firstname.sendKeys(firstname);

    }

    public void inputSurname(String surname) {
        this.lastname.click();
        this.lastname.sendKeys(surname);
    }

    public void inputCountry(String country){
        this.country.click();
        this.country.sendKeys(country);
        this.country.sendKeys(Keys.TAB,Keys.TAB);
    }
}
