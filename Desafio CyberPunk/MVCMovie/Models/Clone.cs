using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.ComponentModel.DataAnnotations;

namespace MVCMovie.Models
{
    public class Clone
    {
        public Clone()
        {
            this.Equipamentos = new HashSet<Equipamento>();
        }

        public virtual ICollection<Equipamento> Equipamentos { get; set; }


        public int id { get; set; }
        [RegularExpression(@"^[A-Z]{3}[0-9]{4}\s*$")]
        [Required]
        public String nome { get; set; }
        [Range(10, 20)]
        public int idade { get; set; }
        [DataType(DataType.DateTime)]
        [DisplayFormat(DataFormatString = "{0:dd-MM-yyyy}", ApplyFormatInEditMode = true)]
        public DateTime data_Criacao { get; set; }
       

    }


    public class CloneDBContext : DbContext
    {
        public DbSet<Clone> Clones { get; set; }
        public DbSet<Equipamento> Equipamentos { get; set; }

        //public System.Data.Entity.DbSet<Equipamento> Equipamentos { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {

            modelBuilder.Entity<Clone>()
                        .HasMany<Equipamento>(s => s.Equipamentos)
                        .WithMany(c => c.Clones)
                        .Map(cs =>
                        {
                            cs.MapLeftKey("CloneRefId");
                            cs.MapRightKey("EquipamentoRefId");
                            cs.ToTable("CloneEquipamento");
                        });

        }


    }
}