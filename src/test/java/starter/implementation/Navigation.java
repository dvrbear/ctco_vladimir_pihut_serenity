package starter.implementation;

import com.google.gson.Gson;
import starter.utils.jsondata.Building;
import starter.utils.jsondata.Location;
import starter.utils.jsondata.Roadmap;

import java.io.FileReader;
import java.util.List;

import static starter.utils.ConstXpath.*;

public class Navigation extends BasePageObject {

    public void navigateToOffice(String officeId) {
        try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader("src/test/resources/navigation/roadmap.json");
            Roadmap roadmap = gson.fromJson(fileReader, Roadmap.class);
            System.out.println(roadmap);


            String[] xpaths = new String[2];
            List<Building> buildings = roadmap.building;

            for (Building build : buildings) {
                for (Location location : build.office) {
                    if (location.id.equals(officeId)) {
                        xpaths[0] = build.xpath;
                        xpaths[1] = location.xpath;
                    }
                }
            }
            gotoHome();
            gotoBooking();
            gotoWorkplace();
            gotoBuildings(xpaths[0]);
            gotoOffice(xpaths[1]);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void navigateToParking(String parkingId) {
        try {
            Gson gson = new Gson();
            FileReader fileReader = new FileReader("src/test/resources/navigation/roadmap.json");
            Roadmap roadmap = gson.fromJson(fileReader, Roadmap.class);
            System.out.println(roadmap);


            String[] xpaths = new String[2];
            List<Building> buildings = roadmap.building;

            for (Building build : buildings) {
                for (Location parking : build.parking) {
                    if (parking.id.equals(parkingId)) {
                        xpaths[0] = build.xpath;
                        xpaths[1] = parking.xpath;
                    }
                }
            }
            gotoHome();
            gotoBooking();
            gotoParking();
            gotoBuildings(xpaths[0]);
            gotoOffice(xpaths[1]);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void gotoHome() {
        click(LOGO_XP);
    }

    public void gotoBooking() {
        click(EXPAND_NAVBAR_XP);
        click(MENU_ICON_MAP_XP);
    }

    public void gotoWorkplace() {
        click(WORKPLACE_XP);
    }

    public void gotoParking() {
        click(PARKING_XP);
    }

    public void gotoBuildings(String buildXpath) {
        click(buildXpath);
    }

    public void gotoOffice(String offXpath) {
        click(offXpath);
    }

    public void sleep(int sec) {
       super.sleep(sec);
    }

}
