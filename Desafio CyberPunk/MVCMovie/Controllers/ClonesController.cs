using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MVCMovie.Models;

namespace MVCMovie.Controllers
{
    public class ClonesController : Controller
    {
        private CloneDBContext db = new CloneDBContext();

        // GET: Clones
        public ActionResult Index()
        {
            return View(db.Clones.ToList());
        }

        // GET: Clones/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Clone clone = db.Clones.Find(id);
            if (clone == null)
            {
                return HttpNotFound();
            }
            return View(clone);
        }

        // GET: Clones/Create
        public ActionResult Create()
        {
            //EquipamentoAPIController equipamentoAPI = new EquipamentoAPIController();
           // IEnumerable<Equipamento> listaEquipamentos = equipamentoAPI.Get();
            return View();
        }

        // POST: Clones/Create
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,nome,idade")] Clone clone)
        {
            clone.data_Criacao = DateTime.Now;

            if (ModelState.IsValid)
            {
                db.Clones.Add(clone);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(clone);
        }

        // GET: Clones/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Clone clone = db.Clones.Find(id);
            if (clone == null)
            {
                return HttpNotFound();
            }
            return View(clone);
        }

        // POST: Clones/Edit/5
        // Para se proteger de mais ataques, ative as propriedades específicas a que você quer se conectar. Para 
        // obter mais detalhes, consulte https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,nome,idade")] Clone clone)
        {
            clone.data_Criacao = DateTime.Now;

            if (ModelState.IsValid)
            {
                db.Entry(clone).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(clone);
        }

        // GET: Clones/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Clone clone = db.Clones.Find(id);
            if (clone == null)
            {
                return HttpNotFound();
            }
            return View(clone);
        }

        // POST: Clones/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Clone clone = db.Clones.Find(id);
            db.Clones.Remove(clone);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
