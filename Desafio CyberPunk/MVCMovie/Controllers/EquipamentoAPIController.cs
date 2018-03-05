using MVCMovie.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace MVCMovie.Controllers
{
    public class EquipamentoAPIController : ApiController
    {

        private CloneDBContext db = new CloneDBContext();

        // GET: Equipamentos
      

        // GET: api/EquipamentoAPI
        public IEnumerable<Equipamento> Get()
        {
            
            return db.Equipamentos.ToList();
        }

        // GET: api/EquipamentoAPI/5
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/EquipamentoAPI
        public void Post([FromBody]string value)
        {
        }

        // PUT: api/EquipamentoAPI/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/EquipamentoAPI/5
        public void Delete(int id)
        {
        }
    }
}
