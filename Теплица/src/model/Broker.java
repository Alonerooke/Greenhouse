package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.controller.Event;
import sample.Controller;

import java.util.HashMap;

public class Broker {
    private Controller controller;
    private HashMap<Class<?>, Circle> eventColorHashMap = new HashMap<>();

    public Broker(Controller controller) {
        this.controller = controller;
        eventColorHashMap.put(GreenhouseControls.LightOn.class, controller.lightCircle);
        eventColorHashMap.put(GreenhouseControls.LightOff.class, controller.lightCircle);
        eventColorHashMap.put(GreenhouseControls.WaterOn.class, controller.waterCircle);
        eventColorHashMap.put(GreenhouseControls.WaterOff.class, controller.waterCircle);
        eventColorHashMap.put(GreenhouseControls.ThermostatDay.class, controller.thermCircle);
        eventColorHashMap.put(GreenhouseControls.ThermostatNight.class, controller.thermCircle);
    }

    public void checkEvent(Event e) {
        controller.label.setText(e.toString());
        try {
            if (eventColorHashMap.get(e.getClass()).getFill() == Color.DARKGREEN) {
                eventColorHashMap.get(e.getClass()).setFill(Color.DARKRED);
            } else {
                eventColorHashMap.get(e.getClass()).setFill(Color.DARKGREEN);
            }
        } catch (Exception exception) {
            System.out.println("У события нет датчика");
        }
    }
}
