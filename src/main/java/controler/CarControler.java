package controler;

import java.util.List;

import javax.enterprise.context.SessionScoped;

import bean.Car;
import javax.inject.Named;
import service.CarService;

@Named("car")
@SessionScoped
public class CarControler {
	private Car car;
	private List<Car> items;
	private CarService carService = new CarService();

	public Car getCar() {
		return car;
	}

	public void setCar() {
		car = new Car();
		carService.insrt();
		// this.car = car;
	}

	public List<Car> getItems() {
		return items;
	}

	public void setItems(List<Car> items) {
		this.items = items;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}
