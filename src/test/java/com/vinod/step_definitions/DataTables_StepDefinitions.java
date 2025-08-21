package com.vinod.step_definitions;

import com.vinod.pages.DropdownsPage;
import com.vinod.utilities.BrowserUtils;
import com.vinod.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {

        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);

        System.out.println(fruitsAndVegetables.get(1));

    }

    @Then("I will share my favorites")
    public void i_will_share_my_favorites(List<String> listOfPets) {

        System.out.println("listOfPets = " + listOfPets);

    }


    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String, String> driverInfo) {

        System.out.println("driverInfo = " + driverInfo);

        System.out.println("driverInfo.get(\"name\") = " + driverInfo.get("name"));
        System.out.println("driverInfo.get(\"address\") = " + driverInfo.get("address"));
        System.out.println("driverInfo.size() = " + driverInfo.size());

    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }



    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        DropdownsPage dropdownsPage = new DropdownsPage();
        List<String> actualMonths = BrowserUtils.dropdownOptions_as_STRING(dropdownsPage.monthDropdown);
        System.out.println("actuals"+actualMonths);
        System.out.println("expected:"+expectedMonths);
        Assert.assertEquals(expectedMonths, actualMonths );

    }

    @Then("we should see table with below content")
    public void we_should_see_table_with_below_content(List<Map<String,String>> products) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        System.out.println(products);
        for(Map<String, String> map: products){
            System.out.println(map.get("Product")+" "+map.get("Price"));
        }


    }
}
