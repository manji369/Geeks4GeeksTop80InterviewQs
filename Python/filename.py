import re
heading = "Q68Detect and Remove Loop in a Linked List"
heading = re.sub(r'\W\s+', '', heading)
heading = heading.split(' ')
heading[0] = heading[0].lower()
heading[1:] = [heading[i].title() for i in range(1, len(heading))]
filename = ''.join(heading) + '.py'
with open(filename, 'w') as f:
    print("Created file " + filename)
