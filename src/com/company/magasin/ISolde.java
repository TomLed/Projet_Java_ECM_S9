package com.company.magasin;

public interface ISolde {
    double getTaux();
    void setTaux(double nouveauTaux);
    void ActiverSolde(boolean yesorno, double taux);
}
