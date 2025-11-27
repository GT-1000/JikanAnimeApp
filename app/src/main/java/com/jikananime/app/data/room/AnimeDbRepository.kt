import android.content.Context
import androidx.room.Room
import com.jikananime.app.data.room.Anime
import com.jikananime.app.data.room.AnimeDao
import com.jikananime.app.data.room.AppDatabase

object AnimeDbRepository {

    @Volatile
    private var _appDatabase: AppDatabase? = null

    private val animeDao: AnimeDao
        get() = _appDatabase?.animeDao()
            ?: throw IllegalStateException("Database not initialized")

    fun initializeDatabase(context: Context) {
        if (_appDatabase == null) {
            synchronized(this) {
                if (_appDatabase == null) {
                    _appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "my-own-anime-database"
                    ).build()
                }
            }
        }
    }

    suspend fun getMyAnimes(): List<Anime> = animeDao.getAllAnime()

    suspend fun insertAnime(anime: Anime): Long = animeDao.insertAnime(anime)

    suspend fun deleteAnime(id: Int) = animeDao.deleteAnimeById(id)
}
