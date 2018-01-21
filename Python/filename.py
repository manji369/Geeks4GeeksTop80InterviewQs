import re
heading = "Q44Partition a set into two subsets such that the difference of subset sums is minimum"
heading = re.sub(r'\W\s+', '', heading)
heading = heading.split(' ')
heading[0] = heading[0].lower()
heading[1:] = [heading[i].title() for i in range(1, len(heading))]
filename = ''.join(heading) + '.py'
with open(filename, 'w') as f:
    print("Created file " + filename)
