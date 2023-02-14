from PIL import Image
import os
 
print("Empetiteix les imatges d'una carpeta")
folder = input("Ruta de carpeta: ")
w = int(input("ample: "))
h = int(input("alçada: "))
for i in os.listdir(folder):
    file = f"{folder}\\{i}"
    im = Image.open(file)
    im = im.resize((w, h), Image.ANTIALIAS)
    im.save(file)