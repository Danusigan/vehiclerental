package vehicle1.example.vehiclerent.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/vehicle_booking.feature",
        glue = "vehicle1.example.vehiclerent.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/vehicle-booking-report.html",
                "json:target/cucumber-reports/vehicle-booking-report.json"
        },
        monochrome = true,
        tags = "@VehicleBooking" // Optional: tag specific scenarios
)
public class VehicleBookingCucumberTest {
}
