package com.parasoft.parabank.graphwalker.modelimpl;

import com.parasoft.parabank.graphwalker.Base.TestExecutionContext;
import com.parasoft.parabank.graphwalker.utils.Coverage;
import com.parasoft.parabank.graphwalker.utils.Driver;
import com.parasoft.parabank.graphwalker.utils.Helpers;
import com.parasoft.parabank.graphwalker.utils.Urls;
import org.graphwalker.FindTransactions;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@GraphWalker(value = Coverage.Default)
public class FindTransactionsImpl extends TestExecutionContext implements FindTransactions {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    private static final String todayString = LocalDate.now().format(formatter);

    private void ClickFindTransactionsId() {
        WebElement idFindTransactionsButton = Driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[3]/button"));
        idFindTransactionsButton.click();
    }

    private void ClickFindTransactionsDate() {
        WebElement dateFindTransactionsButton = Driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[5]/button"));
        dateFindTransactionsButton.click();
    }

    private void ClickFindTransactionsDateRange() {
        WebElement dateRangeFindTransactionsButton = Driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[7]/button"));
        dateRangeFindTransactionsButton.click();
    }

    private void ClickFindTransactionsAmount() {
        WebElement amountFindTransactionsButton = Driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[9]/button"));
        amountFindTransactionsButton.click();
    }

    private String getValidTransactionId() {
        // TODO: This might not be a valid transaction ID depending on the database state. Sadly does not start from 0, 1, ...
        return "14476";
    }

    @Override
    public void e_Select_Account() {
        WebElement dropdown = Driver.findElement(By.xpath("//*[@id='accountId']"));
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        options.get(Helpers.random.nextInt(options.size())).click();
    }

    @Override
    public void e_Navigate() {
        Driver.navigateTo(Urls.ACCOUNTS_OVERVIEW_URL);
    }

    @Override
    public void v_Dummy_Navigation_SHARED() {
        Assert.assertFalse(Driver.containsUrl(Urls.INDEX_URL));
    }

    @Override
    public void e_No_Action() {
        // No action
    }

    @Override
    public void v_Transaction_Results() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        Assert.assertTrue(Driver.containsText("Transaction Results"));
    }

    @Override
    public void v_Transaction_Details() {
        Assert.assertTrue(Driver.containsUrl(Urls.TRANSACTION_DETAILS_URL));
        Assert.assertTrue(Driver.containsText("Transaction Details"));
    }

    @Override
    public void v_Account_Selected() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
    }

    @Override
    public void e_Click_Transaction() {
        WebElement transaction = Driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[2]/a"));
        transaction.click();
    }

    @Override
    public void v_Invalid_Input_Error() {
        Driver.waitFor(50);
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        Assert.assertTrue(Driver.containsText("An internal error has occurred and has been logged."));
    }

    @Override
    public void v_Find_Transactions_SHARED() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
    }

    @Override
    public void v_Find_By_Date_Invalid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By date = By.xpath("//*[@id='criteria.onDate']");
        Assert.assertEquals("abc", Driver.findElement(date).getAttribute("value"));
    }

    @Override
    public void e_Fill_Amount_Valid() {
        By amount = By.xpath("//*[@id='criteria.amount']");
        Driver.clearField(amount);
        Driver.fillField(amount, "100");
    }

    @Override
    public void e_Invalid_Date_Range_Find_Transactions() {
        ClickFindTransactionsDateRange();
    }

    @Override
    public void e_Invalid_Id_Find_Transactions() {
        ClickFindTransactionsId();
    }

    @Override
    public void e_Fill_Date_Range_Valid() {
        By from = By.xpath("//*[@id='criteria.fromDate']");
        By to = By.xpath("//*[@id='criteria.toDate']");
        Driver.clearField(from);
        Driver.fillField(from, "01-01-2022");
        Driver.clearField(to);
        Driver.fillField(to, "01-01-2050");
    }

    @Override
    public void v_Find_By_Date_Range_Invalid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By from = By.xpath("//*[@id='criteria.fromDate']");
        By to = By.xpath("//*[@id='criteria.toDate']");
        Assert.assertEquals("a12", Driver.findElement(from).getAttribute("value"));
        Assert.assertEquals("34b", Driver.findElement(to).getAttribute("value"));
    }

    @Override
    public void e_Invalid_Amount_Find_Transactions() {
        ClickFindTransactionsAmount();
    }

    @Override
    public void e_Fill_Id_Valid() {
        By id = By.xpath("//*[@id='criteria.transactionId']");
        Driver.clearField(id);
        Driver.fillField(id, getValidTransactionId());
    }

    @Override
    public void e_Valid_Date_Range_Find_Transactions() {
        ClickFindTransactionsDateRange();
    }

    @Override
    public void v_Find_By_Amount_Valid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By amount = By.xpath("//*[@id='criteria.amount']");
        Assert.assertEquals("100", Driver.findElement(amount).getAttribute("value"));
    }

    @Override
    public void e_Fill_Amount_Invalid() {
        By amount = By.xpath("//*[@id='criteria.amount']");
        Driver.clearField(amount);
        Driver.fillField(amount, "abc");
    }

    @Override
    public void e_Fill_Date_Range_Invalid() {
        By from = By.xpath("//*[@id='criteria.fromDate']");
        By to = By.xpath("//*[@id='criteria.toDate']");
        Driver.clearField(from);
        Driver.fillField(from, "a12");
        Driver.clearField(to);
        Driver.fillField(to, "34b");
    }

    @Override
    public void e_Valid_Amount_Find_Transactions() {
        ClickFindTransactionsAmount();
    }

    @Override
    public void v_Find_By_Date_Range_Valid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By from = By.xpath("//*[@id='criteria.fromDate']");
        By to = By.xpath("//*[@id='criteria.toDate']");
        Assert.assertEquals("01-01-2022", Driver.findElement(from).getAttribute("value"));
        Assert.assertEquals("01-01-2050", Driver.findElement(to).getAttribute("value"));
    }

    @Override
    public void e_Fill_Date_Valid() {
        WebElement date = Driver.findElement(By.xpath("//*[@id='criteria.onDate']"));
        date.sendKeys(todayString);
    }

    @Override
    public void v_Find_By_Id_Invalid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        WebElement id = Driver.findElement(By.xpath("//*[@id='criteria.transactionId']"));
        Assert.assertEquals("abc", id.getAttribute("value"));
    }

    @Override
    public void e_Fill_Id_Invalid() {
        By id = By.xpath("//*[@id='criteria.transactionId']");
        Driver.clearField(id);
        Driver.fillField(id, "abc");
    }

    @Override
    public void v_Find_By_Id_Valid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By id = By.xpath("//*[@id='criteria.transactionId']");
        Assert.assertEquals(getValidTransactionId(), Driver.findElement(id).getAttribute("value"));
    }

    @Override
    public void v_Find_By_Date_Valid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By date = By.xpath("//*[@id='criteria.onDate']");
        Assert.assertEquals(todayString, Driver.findElement(date).getAttribute("value"));
    }

    @Override
    public void e_Fill_Date_Invalid() {
        By date = By.xpath("//*[@id='criteria.onDate']");
        Driver.clearField(date);
        Driver.fillField(date, "abc");
    }

    @Override
    public void v_Find_By_Amount_Invalid() {
        Assert.assertTrue(Driver.containsUrl(Urls.FIND_TRANSACTIONS_URL));
        By amount = By.xpath("//*[@id='criteria.amount']");
        Assert.assertEquals("abc", Driver.findElement(amount).getAttribute("value"));
    }

    @Override
    public void e_Invalid_Date_Find_Transactions() {
        ClickFindTransactionsDate();
    }

    @Override
    public void e_Valid_Id_Find_Transactions() {
        ClickFindTransactionsId();
    }

    @Override
    public void e_Valid_Date_Find_Transactions() {
        ClickFindTransactionsDate();
    }
}
