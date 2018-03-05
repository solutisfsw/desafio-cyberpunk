using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.ComponentModel.DataAnnotations;

namespace MVCMovie.Models
{
    public class Equipamento
    {

        public Equipamento()
        {
            this.Clones = new HashSet<Clone>();
        }

        public virtual ICollection<Clone> Clones { get; set; }


        public int id { get; set; }
        public String nome_equipamento { get; set; }


    }

   /* public class EquipamentoDBContext : DbContext
    {
        public DbSet<Equipamento> Equipamentos { get; set; }

        public System.Data.Entity.DbSet<Clone> Clones { get; set; }
    }
    */
}