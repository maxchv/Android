import os
import os.path
with open('files.txt', 'w') as r:
 for d, dirs, files in os.walk('.'):
         for f in files:
                 path = os.path.join(d, f)
                 if os.path.getsize(path) >= 100e6:
                    r.write(path + ": " + f + "\n")
                 
