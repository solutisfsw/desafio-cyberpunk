using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Model;
using System.Linq;
using Firebase.Database;
using Firebase.Database.Query;
using Helper;

namespace DAL
{
    public class CloneDAL : IDal<CloneModel>
    {
        readonly object ObjectLock = new object();

        public FirebaseClient _conn;
        public FirebaseClient Conn
        {
            get
            {
                if (_conn == null)
                    lock (ObjectLock)
                        if (_conn == null)
                            _conn = new FirebaseClient($"{Util.UrlFirebase}", new FirebaseOptions
                            {
                                AuthTokenAsyncFactory = () => Util.AuthToken()
                            });

                return _conn;
            }
        }
        
        public async Task<IEnumerable<AdicionalModel>> GetAllAdicinal()
        {
            var list = await Conn.Child("Adicional").OnceAsync<AdicionalModel>();

            return list.Select(a => a.Object);
        }

        public async Task AddAsync(CloneModel model)
        {
            try
            {
                await Conn.Child("Clone")
                            .PostAsync(new
                {
                    model.Nome,
                    model.Idade,
                    datacriacao = Util.GetTimeServer,
                    adicionais = model.Adicionais?.Select(a => a)
                });
            }
            catch (Exception err)
            {
                throw err;
            }
        }
        
        public async Task DeleteAsync(CloneModel model)
        {
            try
            {
                await Conn.Child("Clone")
                            .Child(model.Id)
                            .DeleteAsync();
            }
            catch (Exception err)
            {
                throw err;
            }
        }
        
        public async Task<IEnumerable<CloneModel>> GetAllAsync(CloneModel model)
        {
            try
            {
                var r = await Conn.Child("Clone")
                                    .OnceAsync<CloneModel>();

                var list = r.Select(a => { a.Object.Id = a.Key; return a.Object; });               

                return list;
            }
            catch (Exception err)
            {
                throw err;
            }
        }

        public async Task UpdateAsync(CloneModel model)
        {
            try
            {
                await Conn.Child("Clone")
                    .Child(model.Id)
                    .PatchAsync(new
                {
                    model.Nome,
                    model.Idade,
                    adicionais = model.Adicionais?.Select(a => a)
                });                
            }
            catch (Exception err)
            {
                throw err;
            }
        }
    }
}
