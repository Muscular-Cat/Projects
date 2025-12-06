import csv
import dns.resolver

def main():

    fileContents = []

    with open("DOMAINS.csv", "r") as file:

        for line in file:
            
            fileContents.append([line.strip()])

    x = 0    
    for domain in fileContents:

        #SPF

        record = dns.resolver.resolve(domain[0], 'TXT')

        for data in record:
                string = str(data)
                if "v=spf1" in string:
                    domain.append(string)
        if len(domain) < 2:
             domain.append("")
        fileContents[x] = domain

        #DMARC

        Ddomain = "_dmarc." + domain[0]

        record = dns.resolver.resolve(Ddomain, 'TXT')

        for data in record:
                string = str(data)
                if "v=DMARC1" in string:
                    domain.append(string)
        if len(domain) < 3:
             domain.append("")
        fileContents[x] = domain

        x+=1

    #Print Results
    for line in fileContents:
         
        print(f"Domain: {line[0]}")
        print(f"SPF: {line[1]}")
        print(f"DMARC: {line[2]}")
        print()

if __name__ == "__main__":
    main()
