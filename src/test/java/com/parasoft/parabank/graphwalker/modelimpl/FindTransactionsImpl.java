package com.parasoft.parabank.graphwalker.modelimpl;

import com.parasoft.parabank.graphwalker.Base.TestExecutionContext;
import com.parasoft.parabank.graphwalker.utils.Coverage;
import com.parasoft.parabank.graphwalker.utils.Driver;
import com.parasoft.parabank.graphwalker.utils.Helpers;
import org.graphwalker.FindTransactions;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@GraphWalker(value = Coverage.RandomEdgeCoverage100)
public class FindTransactionsImpl extends TestExecutionContext implements FindTransactions {
    @Override
    public void e_Select_Account() {
        WebElement dropdown = Driver.findElement(By.xpath("//*[@id='accountId']"));
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        options.get(Helpers.random.nextInt(options.size())).click();
    }

    @Override
    public void e_Navigate() {

    }

    @Override
    public void v_Dummy_Navigation_SHARED() {

    }

    @Override
    public void e_No_Action() {

    }

    @Override
    public void v_Transaction_Results() {

    }

    @Override
    public void v_Transaction_Details() {

    }

    @Override
    public void v_Account_Selected() {

    }

    @Override
    public void e_Click_Transaction() {

    }

    @Override
    public void v_Invalid_Input_Error() {

    }

    @Override
    public void v_Find_Transactions_SHARED() {

    }

    @Override
    public void v_Find_By_Date_Invalid() {

    }

    @Override
    public void e_Fill_Amount_Valid() {

    }

    @Override
    public void e_Invalid_Date_Range_Find_Transactions() {

    }

    @Override
    public void e_Invalid_Id_Find_Transactions() {

    }

    @Override
    public void e_Fill_Date_Range_Valid() {

    }

    @Override
    public void v_Find_By_Date_Range_Invalid() {

    }

    @Override
    public void e_Invalid_Amount_Find_Transactions() {

    }

    @Override
    public void e_Fill_Id_Valid() {

    }

    @Override
    public void e_Valid_Date_Range_Find_Transactions() {

    }

    @Override
    public void v_Find_By_Amount_Valid() {

    }

    @Override
    public void e_Fill_Amount_Invalid() {

    }

    @Override
    public void e_Fill_Date_Range_Invalid() {

    }

    @Override
    public void e_Valid_Amount_Find_Transactions() {

    }

    @Override
    public void v_Find_By_Date_Range_Valid() {

    }

    @Override
    public void e_Fill_Date_Valid() {

    }

    @Override
    public void v_Find_By_Id_Invalid() {

    }

    @Override
    public void e_Fill_Id_Invalid() {

    }

    @Override
    public void v_Find_By_Id_Valid() {

    }

    @Override
    public void v_Find_By_Date_Valid() {

    }

    @Override
    public void e_Fill_Date_Invalid() {

    }

    @Override
    public void v_Find_By_Amount_Invalid() {

    }

    @Override
    public void e_Invalid_Date_Find_Transactions() {

    }

    @Override
    public void e_Valid_Id_Find_Transactions() {

    }

    @Override
    public void e_Valid_Date_Find_Transactions() {

    }

//    @Override
//    public void e_Fill_Date_Range() {
//        WebElement from = Driver.findElement(By.xpath("//*[@id='criteria.fromDate']"));
//        WebElement to = Driver.findElement(By.xpath("//*[@id='criteria.toDate']"));
//        from.sendKeys("13-03-2023");
//        to.sendKeys("13-03-2025");
//    }
}
