using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace İkiliAramaAgaci
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        İkiliAramaAgaci aramaAgaci;

        private void btnOrder_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Ağaç üzerinde dolaşmak için öncelikle ağacı oluşturmalısınız!");
            }
            else
            {
                switch (cmbTraverseType.SelectedIndex)
                {
                    case 0:
                        aramaAgaci.PreOrder();
                        break;
                    case 1:
                        aramaAgaci.InOrder();
                        break;
                    case 2:
                        aramaAgaci.PostOrder();
                        break;
                    default:
                        break;
                }
                txtSonuc.Text = aramaAgaci.DugumleriYazdir();
            }
        }

        private void btnDugumSayisi_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Ağaç üzerinde dolaşmak için öncelikle ağacı oluşturmalısınız!");
            }
            else
            {
                MessageBox.Show(aramaAgaci.DugumSayisi().ToString());
            }
        }

        private void btnYaprakSayisi_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Ağaç üzerinde dolaşmak için öncelikle ağacı oluşturmalısınız!");
            }
            else
            {
                MessageBox.Show(aramaAgaci.YaprakSayisi().ToString());
            }
        }

        private void btnBSTOlustur_Click(object sender, EventArgs e)
        {
            aramaAgaci = new İkiliAramaAgaci();
            aramaAgaci.Ekle(15);
            aramaAgaci.Ekle(6);
            aramaAgaci.Ekle(3);
            aramaAgaci.Ekle(2);
            aramaAgaci.Ekle(4);
            aramaAgaci.Ekle(7);
            aramaAgaci.Ekle(13);
            aramaAgaci.Ekle(18);
            aramaAgaci.Ekle(17);
            aramaAgaci.Ekle(20);

            MessageBox.Show("İkili Arama Ağacı başarılı ile oluşturuldu...");
        }

        private void btnAra_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Öncelikle ağacı oluşturmalısınız!");
                return;
            }                

            İkiliAramaAgacDugumu dugum = aramaAgaci.Ara(Convert.ToInt16(txtAra.Text));
            if (dugum != null)
                MessageBox.Show(dugum.veri + " düğümü bulundu.");
            else
                MessageBox.Show(txtAra.Text + " düğümü bulunamadı....");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void btnMinDeger_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Öncelikle ağacı oluşturmalısınız!");
                return;
            }

            İkiliAramaAgacDugumu dugum = aramaAgaci.MinDeger();
            if (dugum != null)
                MessageBox.Show("Minimum değerli " + dugum.veri.ToString() + " düğümü bulundu.");
            else
                MessageBox.Show("Minimum değerli düğüm bulunamadı....");

        }

        private void btnMaksDeger_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Öncelikle ağacı oluşturmalısınız!");
                return;
            }

            İkiliAramaAgacDugumu dugum = aramaAgaci.MaksDeger();
            if (dugum != null)
                MessageBox.Show("Maksimum değerli " + dugum.veri.ToString() + " düğümü bulundu.");
            else
                MessageBox.Show("Maksimum değerli düğüm bulunamadı....");

        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Öncelikle ağacı oluşturmalısınız!");
                return;
            }

            aramaAgaci.Ekle(Convert.ToInt16(txtInsert.Text));

            MessageBox.Show(txtInsert.Text + " elemanı eklendi");
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (aramaAgaci == null)
            {
                MessageBox.Show("Öncelikle ağacı oluşturmalısınız!");
                return;
            }

            aramaAgaci.Sil(Convert.ToInt16(txtDelete.Text));

            MessageBox.Show(txtDelete.Text + " elemanı silindi");

        }

    }
}
