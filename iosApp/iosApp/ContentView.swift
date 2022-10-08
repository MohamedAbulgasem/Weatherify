import SwiftUI
import shared

struct ContentView: View {

    let weatherify = WeatherifyCompanion().create(
			apiKey: "fzc7nsad7pz48",
			withCachingEnabled: true
	)

	var body: some View {
		Text(weatherify.getWeatherForecast())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}