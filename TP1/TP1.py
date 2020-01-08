# Importer le module numpy pour manipuler des vecteurs / matrices
import numpy as np

# Importer le module matplotlib.pyplot pour l'affichage de figures
import matplotlib.pyplot as plt

# Permettre l'affichage de surfaces 3D
from mpl_toolkits.mplot3d import Axes3D

# Fermeture des figures précédemment ouvertes
plt.close('all')

# Définition des échantillons sur un axe
axe = np.linspace(0, 1, 101)

# Définition des éléments de surface
x = np.ones((101,1)).dot(axe.reshape((1,101)))
y = axe.reshape((101,1)).dot(np.ones((1,101)))

# Position de la source
n = 13
sourcex = np.linspace(0,4, n)
sourcey = np.linspace(0,4, n)
temp = 0
tempEl = 0
#xs = 0.5
#ys = 0.5
e = np.zeros((101,101))
eL = np.zeros((101,101))
# Calcul de la distance (somme de matrice)
#d = np.sqrt((x - xs) * (x - xs) + (y - ys) * (y - ys))
for xi in range(101) :
    for yi in range(101) :
        temp = 0
        tempEl = 0
        for sox in sourcex :
            for soy in sourcey :
                d = np.sqrt((xi/100 - sox) * (xi/100 - sox) + (yi/100 - soy) * (yi/100 - soy))
                temp = temp + ((100/2 * np.pi) * 0.5)/(np.power(np.power(d,2) + np.power(0.5,2),1.5))       
                e[xi,yi] = temp
                tempEl = tempEl + ((100/2 * np.pi) * np.power(0.5,2))/ (np.power(np.power(d,2) + np.power(0.5,2),2))
                eL[xi,yi] = tempEl
                
    
# Calcul de l'éclairement surface lambertienne
#e = ((100/2 * np.pi) * 0.5)/ (np.power(np.power(d,2) + np.power(0.5,2),1.5))
#eL = ((100/2 * np.pi) * np.power(0.5,2))/ (np.power(np.power(d,2) + np.power(0.5,2),2))

# Création d'une figure matplotlib
fig1 = plt.figure()
fig3 = plt.figure()

# Création des axes sur la figure fig1
axes = fig1.gca(projection=Axes3D.name)
axes.set_xlabel('x')
axes.set_ylabel('y')
axes.set_zlabel('d')

eclair = fig3.gca(projection=Axes3D.name)
eclair.set_xlabel('x')
eclair.set_ylabel('y')
eclair.set_zlabel('e')

# Calcul variation eclairement max en %
evar = (np.amax(e) - np.amin(e)) / np.amax(e) *100
eLvar = (np.amax(eL) - np.amin(eL)) / np.amax(eL)*100

# Affichage de la fonction eclairement sur fig1
axes.plot_surface(x, y, e, cmap='coolwarm', rstride=5, cstride=5, antialiased=True)
# Affichage de la fonction eclairement Lambertien sur la fig2
eclair.plot_surface(x, y, eL, cmap='coolwarm', rstride=5, cstride=5, antialiased=True)

# Visualisation de la fonction distance sous forme d'image en niveaux de gris
fig2 = plt.figure()
plt.imshow(eL, cmap='gray')

fig4 = plt.figure()
plt.imshow(e, cmap='gray')
print("Variation Eclairement Maximale : " , evar , "%")
print("Variation Eclairement Lambertien Maximale : " , eLvar , "%")

# Affichade des figures matplotlib à l'écran
plt.show()

