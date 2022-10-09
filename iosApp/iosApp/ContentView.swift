import SwiftUI
import shared

@available(iOS 16.0, *)
struct ContentView: View {
    
    @State var forecast: WeatherForecast? = nil

    let weatherify = WeatherifyCompanion().create(
			apiKey: "www.weatherapi.com API key goes here",
			withCachingEnabled: true
	)
    
    init() {
        weatherify.getWeatherForecast(
            city: "Cape Town",
            days: 1,
            withAirQuality: true
        ) { [self] forecast, error in
            if let forecast = forecast {
                self.forecast = forecast
            } else if let error = error {
                print(error)
            }
        }
    }

	var body: some View {
        Text(forecast.debugDescription)
	}
}

@available(iOS 16.0, *)
struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
