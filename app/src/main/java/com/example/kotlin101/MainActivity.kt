import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.http.GET

//1. Configurer Retrofit pour effectuer une requête à l'API
interface CountryService {
        @GET("all")
}

val retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val countryService = retrofit.create(CountryService::class.java)
//4. Créez un ViewModel pour gérer les données
class CountryViewModel : ViewModel() {
        private val _countries = MutableLiveData<List<Country>>()
        val countries: LiveData<List<Country>> = _countries
        fun loadCountries() {
                viewModelScope.launch {
                        val dataCatcher = countries.CountryService.getInstance().create(CountryService::class.java)
                        try {
                                val countries = countryService.getCountries()

                        } catch (e: Exception) {
                        }
                }
        }
}