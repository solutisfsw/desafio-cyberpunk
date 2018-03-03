using DAL;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Repository
{
    public class CloneRepository : IRepository<CloneModel>
    {
        readonly object ObjectLock = new object();

        CloneDAL _db = null;
        CloneDAL Db
        {
            get
            {
                if (_db == null)
                    lock (ObjectLock)
                        if (_db == null)
                            _db = new CloneDAL();

                return _db;
            }
        }

        async Task Validade(CloneModel model)
        {
            var lClone = await Db.GetAllAsync(model);
            
            if (lClone.Where(m => !m.Id.Equals(model.Id) & model.Nome.ToLower().Equals(m.Nome.ToLower())).Any())
                throw new Exception($"Nome '{model.Nome}' em uso");

            if (model.Adicionais.Any())
            {
                var lAdicional = await Db.GetAllAdicinal();

                foreach(var a in model.Adicionais)
                {
                    if (!lAdicional.Select(o => o.Nome).Contains(a))
                        throw new Exception($"Adicional '{a}' inválido");                    
                };
            }
        }

        public async Task AddAsync(CloneModel model)
        {
            if (model == null)
                throw new Exception("Requisição inválida");

            if (!model.IsNomeValid)
                throw new Exception("Nome inválido");

            if (!model.IsIdadeValid)
                throw new Exception("Idade inválida");

            await Validade(model);
            
            await Db.AddAsync(model);
        }

        public async Task DeleteAsync(CloneModel model)
        {
            if (model == null || string.IsNullOrEmpty(model.Id))
                throw new Exception("Requisição inválida");
            
            await Db.DeleteAsync(model);
        }

        public async Task<IEnumerable<CloneModel>> GetAllAsync(CloneModel model)
        {
            return await Db.GetAllAsync(model);
        }

        public async Task UpdateAsync(CloneModel model)
        {
            if (model == null || string.IsNullOrEmpty(model.Id))
                throw new Exception("Requisição inválida");

            if (!model.IsNomeValid)
                throw new Exception("Nome inválido");

            if (!model.IsIdadeValid)
                throw new Exception("Idade inválida");

            await Validade(model);
            
            await Db.UpdateAsync(model);
        }
    }
}
